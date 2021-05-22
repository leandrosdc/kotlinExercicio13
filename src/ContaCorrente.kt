class ContaCorrente (override var conta:Int = 0,
                     override var saldo:Double = 0.0,
                     var taxaDeOperacao:Double = 2.0): ContaBancaria (conta, saldo), Imprimivel{

    override fun mostrarDados(){
        println("A conta ${this.conta} tem R$${this.saldo} de saldo na conta corrente. Saldo atualizado: R$${this.saldo}")
    }

    override fun depositar(valorDeposito:Double){
        this.saldo += valorDeposito
        println("Valor de R$$valorDeposito depositado na conta Corrente ${this.conta}. Saldo atualizado: R$${this.saldo}")
    }

    override fun sacar(valorSaque:Double):Boolean{
        if (this.saldo >= (valorSaque + taxaDeOperacao)){
            this.saldo -= valorSaque
            this.saldo -= taxaDeOperacao
            println("Operação Realizada: Valor de R$$valorSaque sacado da conta corrente ${this.conta} com custo de R$$taxaDeOperacao. R$${this.saldo}")
            return true
        }else println("Saldo Indisponivel para Saque")
        return false
    }
}