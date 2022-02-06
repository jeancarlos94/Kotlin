class Account(var owner: String, val accountNumber: Int) {
    var balance: Double = 0.0
        private set //Encapsulamento, a variável balance não poderá ser modificada por membros externos à classe Conta

    fun deposit(value: Double){
        if (value > 0.0)
            this.balance += value
    }

    fun withdraw(value: Double): Boolean{
        return when{
            hasSuficientBalance(value) -> {
                this.balance -= value
                true
            }
            else -> false
        }
    }

    fun transfer(value: Double, account: Account): Boolean{
        return when{
            hasSuficientBalance(value) -> {
                this.balance -= value
                account.deposit(value)
                true
            }
            else -> false
        }
    }

    private fun hasSuficientBalance(value: Double): Boolean{
        return when{
            this.balance >= value -> true
            else -> false
        }
    }
}