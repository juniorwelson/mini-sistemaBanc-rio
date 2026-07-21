package model

import model.BankAccount

class CheckingAccount(name: String, age: Int) : BankAccount(name, age) {


    override fun ActiveAccount() {
        var value: Double
        while (true) {
            println("Para ativação da conta , deposite um valor de 50 reais ou mais:")
            println("DEPOSITAR: R$")
            value = readLine()?.toDoubleOrNull() ?: 0.0

            if (value >= 50.0) {
                break
            }

            println("Valor inválido! Tente novamente.\n")
        }
        balance += value
        println("Depósito realizado com sucesso! Saldo: $balance")


    }


    override fun sake(valueSake: Double) {


        if (balance <= 0.0) {
            println("Saldo insuficiente para saque")
            return
        }

        if (valueSake <= 0.0) {
            println("Não pode sacar valores negativos ou zero")
            return
        }

        if (valueSake > balance) {
            println("Saldo insuficiente")
            return
        }

        balance -= valueSake
        println("Saque realizado com sucesso.")
        println("Saldo disponível : R$ $balance")
    }


    override fun deposit() {
        while (true) {
            println("QUERO DEPOSITAR: R$")
            val valueDeposit = readLine()?.toDoubleOrNull() ?: 0.0

            if (valueDeposit == 0.0) {
                println("Não pode depositar R$0.0")
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
        println("Seu saldo CONTA CORRENTE  é de R$ $balance")

    }
}






