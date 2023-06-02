package com.usjt.projetoa3.data.taco

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.usjt.projetoa3.ui.HomeUiState

/**
 * De modo a facilitar a leitura da tabela taco
 * coloquei todas as classes de dados em um único arquivo,
 * isso porque a tabela será somente para leitura.
 */

@Entity(
    tableName = "categories",
    indices = [
        Index(
            name = "categories_name_key",
            unique = true,
            value = ["name"],
            orders = [Index.Order.ASC]
        )
    ]
)
data class Category(
    @PrimaryKey val id: Int,
    val name: String
)

@Entity(
    tableName = "foods",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("categoryId"),
        onDelete = ForeignKey.RESTRICT,
        onUpdate = ForeignKey.CASCADE
    )],
    indices = [
        Index(
            name = "foods_name_key",
            unique = true,
            value = ["name"],
            orders = [Index.Order.ASC]
        )
    ]
)
data class Food(
    @PrimaryKey val id: Int,
    val name: String,
    val categoryId: Int
) {
    fun toHomeUiState(): HomeUiState = HomeUiState(
        id = id,
        name = name,
        categoryId = categoryId
    )
}

@Entity(
    tableName = "amino_acids",
    foreignKeys = [ForeignKey(
        entity = Food::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("foodId"),
        onDelete = ForeignKey.RESTRICT,
        onUpdate = ForeignKey.CASCADE
    )],
    indices = [
        Index(
            name = "amino_acids_foodId_key",
            unique = true,
            value = ["foodId"],
            orders = [Index.Order.ASC]
        )
    ]
)
data class AminoAcids(
    @PrimaryKey val id: Int,
    val foodId: Int,
    val tryptophan: Double,
    val threonine: Double,
    val isoleucine: Double,
    val leucine: Double,
    val lysine: Double,
    val methionine: Double,
    val cystine: Double,
    val phenylalanine: Double,
    val tyrosine: Double,
    val valine: Double,
    val arginine: Double,
    val histidine: Double,
    val alanine: Double,
    val asparticAcid: Double,
    val glutamicAcid: Double,
    val glycine: Double,
    val proline: Double,
    val serine: Double,
)

//@Entity(
//    tableName = "fatty_acids",
//    foreignKeys = [ForeignKey(
//        entity = Food::class,
//        parentColumns = arrayOf("id"),
//        childColumns = arrayOf("foodId"),
//        onDelete = ForeignKey.RESTRICT,
//        onUpdate = ForeignKey.CASCADE
//    )]
//)
//data class FattyAcids(
//    @PrimaryKey val id: Int,
//    val foodId: Int,
//    val saturated: Double,
//    val monounsaturated: Double,
//    val polyunsaturated: Double,
//    @ColumnInfo(name = "12:0") val twelveZero: Double? = null,
//    @ColumnInfo(name = "14:0") val fourteenZero: Double? = null,
//    @ColumnInfo(name = "14:1") val fourteenOne: Double? = null,
//    @ColumnInfo(name = "16:0") val sixteenZero: Double? = null,
//    @ColumnInfo(name = "16:1") val sixteenOne: Double? = null,
//    @ColumnInfo(name = "18:0") val eighteenZero: Double? = null,
//    @ColumnInfo(name = "18:1") val eighteenOne: Double? = null,
//    @ColumnInfo(name = "18:1t") val eighteenOneT: Double? = null,
//    @ColumnInfo(name = "18:2n6") val eighteenTwoNSix: Double? = null,
//    @ColumnInfo(name = "18:2t") val eighteenTwoT: Double? = null,
//    @ColumnInfo(name = "18:3n3") val eighteenThreeNThree: Double? = null,
//    @ColumnInfo(name = "20:0") val twentyZero: Double? = null,
//    @ColumnInfo(name = "20:1") val twentyOne: Double? = null,
//    @ColumnInfo(name = "20:4") val twentyFour: Double? = null,
//    @ColumnInfo(name = "20:5") val twentyFive: Double? = null,
//    @ColumnInfo(name = "22:0") val twentyTwo: Double? = null,
//    @ColumnInfo(name = "22:5") val twentyTwoFive: Double? = null,
//    @ColumnInfo(name = "22:6") val twentyTwoSix: Double? = null,
//    @ColumnInfo(name = "24:0") val twentyFourZero: Double? = null
//)

@Entity(
    tableName = "nutrients",
    foreignKeys = [ForeignKey(
        entity = Food::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("foodId"),
        onDelete = ForeignKey.RESTRICT,
        onUpdate = ForeignKey.CASCADE
    )],
    indices = [
        Index(
            name = "nutrients_foodId_key",
            unique = true,
            value = ["foodId"],
            orders = [Index.Order.ASC]
        )
    ]
)
data class Nutrients(
    @PrimaryKey val id: Int,
    val foodId: Int,
    val moisture: Double? = null,
    val kcal: Double? = null,
    val kJ: Double? = null,
    val protein: Double? = null,
    val lipids: Double? = null,
    val cholesterol: Double? = null,
    val carbohydrates: Double? = null,
    val dietaryFiber: Double? = null,
    val ash: Double? = null,
    val calcium: Double? = null,
    val magnesium: Double? = null,
    val manganese: Double? = null,
    val phosphorus: Double? = null,
    val iron: Double? = null,
    val sodium: Double? = null,
    val potassium: Double? = null,
    val copper: Double? = null,
    val zinc: Double? = null,
    val retinol: Double? = null,
    val re: Double? = null,
    val rae: Double? = null,
    val thiamin: Double? = null,
    val riboflavin: Double? = null,
    val pyridoxine: Double? = null,
    val niacin: Double? = null,
    val vitaminC: Double? = null,
)

@Entity(tableName = "units")
data class Unit(
    @PrimaryKey val id: Int,
    val fieldName: String,
    val unit: String,
    val labelPt: String,
    val infoodsTagname: String? = null,
    val systematicName: String? = null,
    val commonName: String? = null
)

//@Entity
//data class FoodInfo(
//    @Embedded val category: Category,
//    @Relation(parentColumn = "id", entityColumn = "categoryId") val food: Food,
//    @Relation(parentColumn = "id", entityColumn = "foodId") val nutrients: Nutrients
//    @Embedded val food: Food,
//    @Relation(parentColumn = "foods.id", entityColumn = "foodId") val category: Category,
//    @Relation(parentColumn = "foods.id", entityColumn = "foodId") val nutrients: Nutrients
//)