fun main() {
    val joaoAccount = Account(owner = "João", accountNumber = 1000)
    val mariaAccount = Account(owner = "Maria", accountNumber = 2000)

    joaoAccount.deposit(1000.0)
    mariaAccount.deposit(1200.54)

    val lista: MutableList<Account> = mutableListOf(joaoAccount, mariaAccount)

    printAccountInfo(lista)

    //Saque
    println("Saque de 100.0 da conta do João")
    joaoAccount.withdraw(100.0)
    println("Saque de 140.0 da conta da Maria")
    mariaAccount.withdraw(140.0)

    printAccountInfo(lista)

    //Transferencia
    println("Transferiu 40.0 da conta da Maria para a conta do João")
    mariaAccount.transfer(40.0, joaoAccount)
    println("Transferiu 10.0 da conta do João para a conta da Maria")
    joaoAccount.transfer(10.0, joaoAccount)

    printAccountInfo(lista)
}

fun printAccountInfo(lista: MutableList<Account>){
    for (item: Account in lista){
        println("Titular:${item.owner}\nConta:${item.accountNumber}\nSaldo:${item.balance}\n")
    }
}