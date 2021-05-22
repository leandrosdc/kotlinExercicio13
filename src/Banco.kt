class Banco ():Imprimivel {

    var contasBancarias = mutableListOf<ContaBancaria>()

    fun inserirConta(contaBancaria: ContaBancaria) {
        contasBancarias.add(contaBancaria)
    }

    fun removerConta(contaBancaria: ContaBancaria) {
        for (i in contasBancarias) {
            if (i == contaBancaria) {
                contasBancarias.remove(i)
                break
            }
        }
    }

    fun procurarConta(numeroConta: Int): ContaBancaria? {
        for (i in contasBancarias) {
            if (i.conta == numeroConta) return i
        }
        return null
    }

    override fun mostrarDados() {
        contasBancarias.forEach(){
            it.mostrarDados()
        }
    }
}