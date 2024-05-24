package fpoly.vunvph33438.assignment_ph33438.data

import fpoly.vunvph33438.assignment_ph33438.R

data class Product(val name: String, val price: String, val imageRes: Int)

val products = listOf(
    Product("Black Simple Lamp", "$12.00", R.drawable.simple_lamp),
    Product("Minimal Stand", "$25.00", R.drawable.minimal_stand),
    Product("Coffee Chair", "$20.00", R.drawable.chair),
    Product("Simple Desk", "$50.00", R.drawable.desk)
)