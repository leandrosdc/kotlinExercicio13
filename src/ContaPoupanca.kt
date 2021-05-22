class ContaPoupanca (override var conta:Int = 0,
                     override var saldo:Double = 0.0,
                     var limiteConta:Double = 200.0): ContaBancaria (conta, saldo), Imprimivel{

    override fun mostrarDados(){
        println("A conta ${this.conta} tem R$${this.saldo} de saldo na poupança. Saldo atualizado: R$${this.saldo}")
    }

    override fun depositar(valorDeposito:Double){
        this.saldo += valorDeposito
        println("Valor de R$$valorDeposito depositado na conta poupança ${this.conta}. Saldo atualizado: R$${this.saldo}")
    }

    override fun sacar(valorSaque:Double):Boolean{
        if(this.saldo >= -limiteConta && this.saldo + limiteConta >= valorSaque){
            this.saldo -= valorSaque
            println("Operação Realizada: Valor de R$$valorSaque sacado da conta poupança ${this.conta}. Saldo atualizado: R$${this.saldo}")
            return true
        }else println("Saldo Indisponivel para Saque")
        return false
    }
}