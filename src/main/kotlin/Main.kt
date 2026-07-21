// importing class of system
import model.NewUser
import model.BankAccount
import model.CheckingAccount
import model.SavingsAccount

// importing funcionalidade do sistema
import service.UserService


fun main() {
    val user = NewUser()
    println("💳 Bem-vindo ao Banco Dev!")
    println("✨ Vamos começar seu cadastro de forma rápida e segura.\n")

    println("📋 Precisamos de algumas informações:")
    println("Nome:")
    user.name = readLine()?.trim() ?: "nome"

    println("Idade:")
    user.age = readLine()?.toIntOrNull() ?: 0

    val service = UserService()

    if (service.isValid(user)) {
        println("Acesso liberado!")
        var checkingAccount: CheckingAccount? = null
        var savingsAccount: SavingsAccount? = null
        //só passa para a próxima parte se a validação de IsValid for true
        println("${user.name} , o que você deseja?")
        var stopSysten = true

        while (stopSysten) {
            println("\n==========MENU============\n")
            println("Abrir conta --digite 1 ")
            println("Realizar saque --digite 2 ")
            println("Fazer depósito --digite 3 ")
            println("Consultar saldo --digite 4 ")
            println("SAIR --digite 0 ")


            var option = readLine()?.toIntOrNull() ?: 0

            when (option) {

                1 -> {
                    var chooseTypeAccount: Int?

                    while (true) {
                        println("Qual tipo de conta você deseja abrir?")
                        println("1- CONTA CORRENTE")
                        println("2- CONTA POUPANÇA")

                        chooseTypeAccount = readLine()?.toIntOrNull()

                        if (chooseTypeAccount == 1 || chooseTypeAccount == 2) {
                            break
                        } else {
                            println("Opção inválida. Digite apenas 1 ou 2.")
                        }
                    }

                    when (chooseTypeAccount) {
                        1 -> {
                            if (checkingAccount == null) {
                                checkingAccount = CheckingAccount(user.name, user.age)

                                val agency = (1000..9999).random().toString()
                                val numberAccount = (1000..9999).random().toString()

                                checkingAccount!!.verifyTaxId(agency, numberAccount)
                                checkingAccount!!.createPassword()
                                checkingAccount!!.ActiveAccount()
                            } else {
                                println("Conta corrente já criada!")
                            }
                        }

                        2 -> {
                            if (savingsAccount == null) {
                                savingsAccount = SavingsAccount(user.name, user.age)

                                val agency = (1000..9999).random().toString()
                                val numberAccount = (1000..9999).random().toString()

                                savingsAccount!!.verifyTaxId(agency, numberAccount)
                                savingsAccount!!.createPassword()
                                savingsAccount!!.ActiveAccount()
                            } else {
                                println("Conta poupança já criada!")
                            }
                        }
                    }
                }

                2 -> {
                    var chooseTypeSake:Int?
                    while (true) {
                        println("Escolha em qual conta quer realizar o saque")
                        println("1- CONTA CORRENTE")
                        println("2- CONTA POUPANÇA")
                        chooseTypeSake = readLine()?.toIntOrNull()
                        if(chooseTypeSake==1 || chooseTypeSake==2) {
                           break
                        } else {
                            println("Opção Inválida, digite apena 1 ou 2")
                        }
                    }


                    when (chooseTypeSake) {
                        1 -> {

                            if (checkingAccount != null) {
                                println("SALDO DISPONÍVEL ${checkingAccount.balance}")
                                println("VALOR DE SAQUE:R$")
                                val valueSake = readLine()?.toDoubleOrNull() ?: 0.0
                                checkingAccount!!.sake(valueSake)
                            } else {
                                println("Você não tem conta corrente!")
                            }
                        }

                        2 -> {
                            if (savingsAccount != null) {
                                println("VALOR DE SAQUE:R$")
                                val valueSake = readLine()?.toDoubleOrNull() ?: 0.0
                                savingsAccount!!.sake(valueSake)
                            } else {
                                println("Você não tem conta poupança!")
                            }
                        }
                    }
                }

                3 -> {
                    while (true) {
                        println("Escolha em qual conta deseja realizar o depósito:")
                        println("1- CONTA CORRENTE")
                        println("2- CONTA POUPANÇA")

                        val chooseTypeDeposit = readLine()?.toIntOrNull() ?: 0

                        when (chooseTypeDeposit) {
                            1 -> {
                                if (checkingAccount != null) {
                                    checkingAccount.deposit()
                                } else {
                                    println("Você não possui conta")
                                }
                                break
                            }

                            2 -> {
                                if (savingsAccount != null) {
                                    savingsAccount.deposit()
                                } else {
                                    println("Você não possui conta")
                                }
                                break
                            }

                            else -> {
                                println("Opção inválida, tente novamente.")
                            }
                        }
                    }
                }

                4 -> {
                   checkingAccount?.showBalance()
                    savingsAccount?.showBalance()
                }

                0 -> {
                    stopSysten = false
                    println("Saída realizada com sucesso")
                }

                else -> println("Opção inválida")
            }
        }
    } else {
        println("ACESSO NEGADO")
    }
}