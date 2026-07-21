package model

class SavingsAccount(name:String, age:Int): BankAccount( name , age) {

    override fun ActiveAccount() {
        var value: Double
        while (true) {
            println("Para ativação da conta , deposite um valor de 200 reais ou mais:")
            println("DEPOSITAR: R$")
            value = readLine()?.toDoubleOrNull() ?: 0.0

            if (value >= 200.0) {
                break
            }

            println("Valor inválido! Tente novamente.\n")
        }
        balance += value
        println("Depósito realizado com sucesso! Saldo: $balance")

    }


    override fun deposit() {
        while (true) {
            println("QUERO DEPOSITAR: R$")
            val valueDeposit = readLine()?.toDoubleOrNull() ?: 0.0

            if (valueDeposit == 0.0) {
                println("Não pode depositar R$0.0")
                return
            } else if (valueDeposit < 0.0) {
                println("Não pode depositar valores negativos")
            } else {
                println("Depósito realizado com sucesso.")
                balance += valueDeposit
                println("Seu novo saldo é de $balance")
                break
            }

        }

    }

    override fun showBalance() {
        println("Seu saldo na CONTA POUPANÇA  é de R$ $balance")

    }



}