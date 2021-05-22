abstract class ContaBancaria (open var conta:Int = 0,
                              open var saldo:Double = 0.0):Imprimivel{

    open fun depositar(valorDeposito:Double){
        this.saldo += valorDeposito
        println("Valor de R$$valorDeposito depositado na conta ${this.conta}.")
    }

    open fun sacar(valorSaque:Double):Boolean{
        if(this.saldo >= valorSaque){
            this.saldo -= valorSaque
            println("Operação Realizada: Valor de R$$valorSaque sacado da conta ${this.conta}.")
            return true
        }else println("Saldo Indisponivel para Saque - CLASSE PRINCIPAL")
        return false
    }

    open fun transferir(valorTransferencia:Double, contaBancaria: ContaBancaria){
        if(sacar(valorTransferencia)) {
            contaBancaria.depositar(valorTransferencia)
            println("Valor de R$$valorTransferencia transferido para conta ${contaBancaria.conta}. Saldo atualizado: R$${this.saldo}.")
        }else("Saldo Indisponivel: Não foi possivel realizar a transferencia do valor")
    }

    override fun mostrarDados(){
        println("A conta ${this.conta} tem R$${this.saldo} de saldo.")
    }
}