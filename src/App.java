import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        
        /* CADASTRO DE PACIENTES */
        Paciente p1 = new Paciente("Lucinedes", "123", 12, "r. alberto", "11 11111111", "dores");
        Paciente p2 = new Paciente("Thalita", "456", 20, "r. florentino", "22 2221111", "febre");
        Paciente p3 = new Paciente("Andressa", "789", 45, "centro", "33 33333333", "febre");
        Paciente p4 = new Paciente("Daniel", "000", 30, "r. petropolis", "44 4444444", "resfriado");
        Paciente p5 = new Paciente("Eduardo", "111", 80, "r. friburgo", "55 5555555", "cansaço");

        /* DECLARAÇÃO DE UMA LISTA DE PACIENTES */
        List<Paciente> lista_pacientes = new ArrayList<>();

        /* CADASTRO DE PACIENTES EM UMA LISTA */
        lista_pacientes.addAll(Arrays.asList(p1,p2,p3,p4,p5));

        /* FILTROS com STREAMS */

        // Idade maior que 30 e nome com inicial N
        lista_pacientes.stream() 
        .filter( p -> p.getIdade() > 30 && p.getNome().charAt(1)=='n' )
        .forEach(System.out::println);

        // Telefone com inicial(ddd) 22
        lista_pacientes.stream() 
        .filter( p -> p.getTelefone().startsWith("22") )
        // .filter(predicate) // não é permitido
        .forEach(System.out::println);

        /* COLLECT com Streams */
        
        // Laudo que contém febre
        List<Paciente> lista_filtrada_febre = lista_pacientes.stream() 
        .filter( p -> p.getLaudo().contains("febre") )
        .collect(Collectors.toList());

        // IMPORTACAO ESTATICA "COLLECTORS"
        List<Paciente> lista_filtrada_febre2 = lista_pacientes.stream() 
        .filter( p -> p.getLaudo().contains("febre") )
        .collect(toList());

        /* OPERADOR SORTED */

        // Ordem inversa
        List<Paciente> lista_filtrada_matricula_par = lista_pacientes.stream() 
        .filter( p -> p.getMatricula() % 2 == 1 ) // é ímpar
        .sorted(Comparator.comparing(Paciente::getNome).reversed())
        .collect(toList());
        
        // Ordem alfabética
        lista_pacientes.stream() 
        .filter( p -> p.getMatricula() % 2 == 0 ) // é par
        .sorted(Comparator.comparing(Paciente::getNome))
        .forEach( p -> System.out.println( p.getNome() ) ); // System.out::println

        /* SUMARIZAÇÃO */
        
        // Sumarização geral
        IntSummaryStatistics resumo = lista_pacientes.stream()
        .collect(Collectors.summarizingInt(Paciente::getIdade));

        System.out.println( "Sumarização das idades: " + resumo );
        System.out.printf( "Qtd de idades: %d - Média das idades %.0f", resumo.getCount(), resumo.getAverage() );

        // Sumarização especifica
        int somaIdades = lista_pacientes.stream()
        .collect(Collectors.summingInt(Paciente::getIdade));
        System.out.println("\nA soma das idades é " + somaIdades);

        // RELATORIO FORMATADO!!!

        /* IMPRIMIR CABEÇALHO FORMATADO */
        System.out.printf("%s %20s %20s %20s %20s\n", "Somatório", "Contagem", "MAXIMO","MINIMO","MEDIA");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (int i = 0; i < 20; i++) {
            System.out.printf("%5d %15d %15d %15d %15d\n", i, i, i, i, i);
        }

        /* IMPRIMIR DADOS FORMATADOS */
        System.out.printf("%s %20s %20s %20s\n", "MATRICULA", "NOME", "ENDERECO","IDADE");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Paciente p : lista_pacientes) {
            System.out.printf( "%d %25s %25s %25d\n", p.getMatricula(), p.getNome(), p.getEndereco(), p.getIdade() );
        }
        
        System.out.println("# RESUMO:");
        System.out.printf("Menor da idade %d - Maior Idade %d\n", resumo.getMin(), resumo.getMax());

        /* REMOCAO DE OBJETOS EM UMA LISTA USANDO REMOVE IF COM FUNCAO*/
        lista_pacientes.removeIf( p -> {
            return p.getIdade() < 3;
        });

        /* REMOCAO DE OBJETOS EM UMA LISTA USANDO REMOVE IF COM LAMBA*/
        lista_pacientes.removeIf( 
            p -> p.getIdade() < 3
        );

    }
}
