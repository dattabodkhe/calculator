package com.example.calculator

import android.R.attr.x
import android.R.attr.y
import androidx.compose.material3.Card
import androidx.compose.ui.unit.IntRect

// higher-order function
 /*fun main(){
    println(sum(2.0,22.0))
    calculator(5.4,5.5,::sum)
}

fun sum(a: Double,b: Double): Double{
    return a+b
}
fun calculator(a: Double, b: Double , gn:(Double, Double)-> Double){
    val result = gn(a,b)
    println(result)
}
 */

//lambdas and expresion//
/*fun main(){
    var fn : (a:Int,b:Int)-> Int= ::sum
    val lambdal ={x:Int,y: Int -> x+y}
    val multilineLamda ={
        println("Hello lambda")
        val a= 2+4
        "hello gayatri"
        2
    }
    val singleParalambda = {x: Int,y:Int -> x+y}

    println(multilineLamda())
}


fun sum(a:Int,b:Int): Int=a+b
fun calculator(a:Int,b:Int,op:(Int, Int)-> Int):Int{
    return op(a,b)
}
 */

/*
fun main(){
    var i = 23

    println(i++ + ++i)

}

 */
/*
fun main() {
    var  i =20
    var j = 33

    val  result = i==21 && j++ ==33
    println(i)
    println(j)

 */
//for loop //
/*
fun main(){
    var number = 2

    for (i in 1..10){
      println(number.toString()+"x"+"="+ number*i)
    }
}
 */

/*
fun main(){
    println(addition(3,4))
    println(addition(3.3,3.6))
}
fun addition(a:Int , b: Int): Int{
    return a+b
}
fun addition(a: Double,b: Double): Double{
    return  a+b
}

 */
//Arrays//

/*
fun main(){
    var arr = arrayOf("one","two","three")
    for ((i , e)in arr .withIndex()){
        println("$i, $e")

    }
    println(arr[0])
    println(arr.get(2))
    arr.set(0,"hello")
    println(arr[0])
}

 */
// OOps concepts//
/*
fun main(){
    val mustang = Car("mustang","disel",44)
    val maruti = Car("maruti","petrol",555)
    println(mustang.name)
    println(maruti.kmRun)


    maruti.carDriving()

    maruti.applyBreaks()
    maruti.kmRun
    maruti.name
    maruti.type

}
class Car(val name:String , val type: String , var kmRun : Int){
    fun carDriving(){
        println("Car is driving")
    }
    fun applyBreaks(){
        println("appled breaks")
    }
}

 */
/*
fun main(){
    val p1 = person("datta",33)
    val p2 = person("b",12)
    println(p1.canVote())
    println(p2.canVote())

}
class person(val name: String,var age: Int){
    fun canVote(): Boolean{
        return age>18
    }
}

 */
/*
fun main(){
    val l1 = konChakaye("mohit",33)
    val l2 = konChakaye("naru", 22)
    println(l1.lok())
    println(l2.lok())
}
class konChakaye(val name : String, var age : Int){
    fun lok(): Boolean{
        return age>33

  }
}

 */

fun main(){
    val op = Calculator()
    println(op.add(33,333))
}
class Calculator{
    lateinit var message: String
    fun add(a: Int, b: Int): Int{
        return a+b
    }
    fun multiply(a : Int,b:Int): Int{
        return a*b
    }
}




















