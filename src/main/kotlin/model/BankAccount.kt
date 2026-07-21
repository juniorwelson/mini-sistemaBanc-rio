package model

open class BankAccount(var name: String, var age: Int) {

    var balance: Double = 0.0

    init {

        require(name.isNotBlank()) {
            "Nome não pode ser vazio"
        }

        require(age >= 18) {
            "Usuário deve ser maior de idade"
        }

    }

    open fun ActiveAccount() {}
    open fun verifyTaxId(agency: String, numberAccount: String) {
        var userTaxId: String
        while (true) {
            println("Para abertura de CONTA CORRENTE é necessário informar CPF:")
            userTaxId = readLine() ?: "0"
            if (userTaxId.length >= 11) {
                println("Conta criada com sucesso ---AGÊNCIA:${agency} ---CONTA :${numberAccount}")
                break
            }
            println("CPF INVÁLIDO")
        }
    }

     open fun createPassword() {

        while (true) {
            println("CRIE SUA SENHA ,no mínimo 4 dígitos e no máximo 8 dígitos")
            println("MINHA SENHA:")
            var myPassword: String = readLine() ?: "0"


            if (myPassword.length < 4 || myPassword.length > 8) {
                println("senha inválida")
            } else {
                println("senha ok")
                break
            }
        }


    }
    open fun deposit()  {}
    open fun sake(valueSake: Double) {}
    open fun showBalance() {}

}