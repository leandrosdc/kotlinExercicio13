import java.util.*

fun main(){
    //Iniciar Scanner
    val scanner = Scanner(System.`in`)
    var opcaoUsuario:Int = -1
    var tipoConta:Int = -1
    var qtdeContas:Int = 0
    var numContaRemover = -1
    var numContaOpcoes = -1
    var opcaoConta:String = ""
    var valorOperacoes:Double = -1.0
    var contaTransferencia:Int = -1

    //Fim Scanner

    //Instanciar Banco
    var banco1 = Banco()

    //Inicio Loop de Usuario
    while(opcaoUsuario != 0){
        //Inicio Menu Principal
        printEspaco()
        println("Bem Vindo ao Banco Teste!")
        println("1 - Criar Conta")
        println("2 - Selecionar Conta")
        println("3 - Remover Conta")
        println("4 - Gerar Relatorio")
        println("0 - Finalizar")
        print("Selecione a opção desejada: ")
        opcaoUsuario = scanner.nextInt()
        if(opcaoUsuario > 4 || opcaoUsuario < 0){
            opcaoUsuario = -1
            println("Opção Invalida")
        }

        //Fim Menu Principal

        when{
            //Inicio Opcao 1
            opcaoUsuario == 1 -> {
                printEspaco()
                println("1 - Corrente")
                println("2 - Poupança")
                println("3 - Menu Principal")
                println("0 - Finalizar")
                print("Selecione a opção desejada: ")
                tipoConta = scanner.nextInt()
                if(tipoConta == 1){
                    var contaCorrente1 = ContaCorrente(conta = qtdeContas)
                    banco1.inserirConta(contaCorrente1)
                    printEspaco()
                    println("Conta Corrente Criada! Número: $qtdeContas")
                    qtdeContas++
                }
                else if(tipoConta == 2){
                    var contaPoupanca1 = ContaPoupanca(conta = qtdeContas)
                    banco1.inserirConta(contaPoupanca1)
                    printEspaco()
                    println("Conta Poupança Criada! Número: $qtdeContas")
                    qtdeContas++
                }else if(tipoConta == 4){
                    opcaoUsuario = 0
                }else println("Voltando ao Menu Principal")
            }
        //Fim Opcao 1

        //Inicio Opcao 2
            opcaoUsuario == 2 -> {
                printEspaco()
                print("Informe o número da Conta: ")
                numContaOpcoes = scanner.nextInt()
                if(banco1.procurarConta(numContaOpcoes) != null){
                    var contaBancaria1 = banco1.procurarConta(numContaOpcoes)
                    printEspaco()
                    println("a - Depositar")
                    println("b - Sacar")
                    println("c - Transferir")
                    println("d - Relatorio da Conta")
                    println("e - Menu Anterior")
                    print("Selecione a opção desejada: ")
                    opcaoConta = scanner.next()
                    if(opcaoConta == "a" && contaBancaria1 != null){
                        printEspaco()
                        print("Informe o valor para deposito: ")
                        valorOperacoes = scanner.nextDouble()
                        contaBancaria1.depositar(valorOperacoes)
                    }else if(opcaoConta == "b" && contaBancaria1 != null){
                        printEspaco()
                        print("Informe o valor para saque: ")
                        valorOperacoes = scanner.nextDouble()
                        contaBancaria1.sacar(valorOperacoes)
                    }else if(opcaoConta == "c" && contaBancaria1 != null){
                        printEspaco()
                        print("Informe o número da conta: ")
                        contaTransferencia = scanner.nextInt()
                            if(contaTransferencia != contaBancaria1.conta && banco1.procurarConta(contaTransferencia) != null){
                                var contaBancaria2 = banco1.procurarConta(contaTransferencia)
                                print("Informe o valor para transferencia: ")
                                valorOperacoes = scanner.nextDouble()
                                if (contaBancaria2 != null) {
                                    contaBancaria1.transferir(valorOperacoes,contaBancaria2)
                                }
                            }else{
                                println("Conta não existente ou igual a primeira selecionada")
                            }
                    }else if(opcaoConta == "d" && contaBancaria1 != null){
                        printEspaco()
                        contaBancaria1.mostrarDados()
                    }else if(opcaoConta == "e" && contaBancaria1 != null){
                        printEspaco()
                        println("Voltando ao Menu Principal")
                    }
                    else{
                        println("Opção Não Existente")
                    }
                }else{
                    println("Conta Não Existente")
                }
            }

        //Fim Opcao 2

        //Inicio Opcao 3
            opcaoUsuario == 3 -> {
                printEspaco()
                print("Informe o número da Conta: ")
                numContaRemover = scanner.nextInt()
                if(banco1.procurarConta(numContaRemover) != null){
                    var contaBancaria1 = banco1.procurarConta(numContaRemover)
                    if (contaBancaria1 != null) {
                        banco1.removerConta(contaBancaria1)
                    }
                    println("Conta $numContaRemover Removida.")
                }else{
                    println("Conta Não Existente")
                }
            }
        //Fim Opcao 3

        //Inicio Opcao 4
            opcaoUsuario == 4 -> {
                printEspaco()
                println("Relatório de Contas Bancarias")
                banco1.mostrarDados()
            }
        //Fim Opcao 4
        }
    }
    printEspaco()
    println("Obrigado por usar o Banco Teste")
}

//funcao de separacao de texto
fun printEspaco(){
    println("---------------------------")
}

