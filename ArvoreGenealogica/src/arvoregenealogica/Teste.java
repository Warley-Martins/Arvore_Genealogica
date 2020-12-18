package arvoregenealogica;

import java.util.Scanner;

public class Teste {
    static Scanner input;
    static Pessoa[] pessoas;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        pessoas = new Pessoa[10];
        casosTeste();
        for(int i = 0; i < pessoas.length; i++){
            printarPessoa(pessoas[i]);
        }
        int opcao;
        Pessoa pessoa;
        do{
            do{
                Menu1();
                opcao = input.nextInt();
                var bug = input.nextLine();
            }while(opcao < 0 || opcao > 3);
            switch(opcao){
                case 1: // conferir irmas
                    conferirIrmaos();
                    break;
                case 2: // conferir igualdade
                    conferirIgualdade();
                    break;
                case 3: // conferir ancestral
                    conferirAncestralidade();
                    break;
            }
        }while(opcao != 0);
    }
    
    public static void casosTeste(){
        pessoas[0] = new Pessoa(null, null, "Bruno");
        pessoas[1] = new Pessoa(null, null, "Melissa");
        pessoas[2] = new Pessoa(pessoas[0], pessoas[1], "Arthur");
        pessoas[3] = new Pessoa(null, null, "Claudio");
        pessoas[4] = new Pessoa(null, null, "Isabel");
        pessoas[5] = new Pessoa(pessoas[3], pessoas[4], "Olivia");
        pessoas[6] = new Pessoa(pessoas[2], pessoas[5], "Manuel");
        pessoas[7] = new Pessoa(pessoas[2], pessoas[5], "Kamilly");
        pessoas[8] = new Pessoa(null, null, "Benicio");
        pessoas[9] = new Pessoa(pessoas[8], null, "Marcia");

    }
    private static void printarPessoa(Pessoa pessoa) {
        var mensagemMae = "a pessoa não possui uma mãe registrada";
        var mensagemPai = "a pessoa não possui um pai registrado";
        if(pessoa.getPai() != null){
            mensagemPai = pessoa.getPai().getNome();
        }
        if(pessoa.getMae() != null){
            mensagemMae = pessoa.getMae().getNome();
        }
        System.out.println("\nNome: " + pessoa.getNome()
                         + "\nPai: " + mensagemPai
                         + "\nMãe: " + mensagemMae);
    }
    private static void Menu1() {
        System.out.print("\nDigite a opção desejada: "
                       + "\n(1). Conferir se duas pessoas são irmãos"
                       + "\n(2). Conferir se duas pessoas são iguais"
                       + "\n(3). Conferir se uma pessoa é ancestral de outra"
                       + "\n(0). Encerrar"
                       + "\nOpção desejada: ");
    }

    private static Pessoa procurarPessoa() {
        Pessoa pessoa = null;
        do{
            System.out.print("Digite o nome da pessoa: ");
            var nome = input.nextLine();
            for(var item : pessoas){
                if(item.nome.equals(nome)){
                    pessoa = item;
                    break;
                }
            }
        }while(pessoa == null);
        return pessoa;
    }
    private static void conferirIrmaos(){
        System.out.println("Pessoa 1: ");
        Pessoa pessoa1 = procurarPessoa();
        System.out.println("Pessoa 2: ");
        Pessoa pessoa2 = procurarPessoa();
        System.out.println("\nAs duas pessoas são irmãs: " + pessoa1.saoIrmaos(pessoa2));
    }

    private static void conferirIgualdade() {
        Pessoa pessoa1 = procurarPessoa();
        Pessoa pessoa2 = procurarPessoa();
        System.out.println("\nAs duas pessoas são iguais: " + pessoa1.saoIguais(pessoa2));
    }

    private static void conferirAncestralidade() {
        System.out.println("Ancestral ");
        Pessoa ancestral = procurarPessoa();
        System.out.println("Pessoa ");
        Pessoa pessoa = procurarPessoa();
        System.out.println(ancestral.getNome()+" é ancestral: "+ pessoa.ehAntecessor(ancestral));

    }
    
}

















