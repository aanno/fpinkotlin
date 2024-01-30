package chapter10

import arrow.core.ListKOf
import arrow.higherkind

//tag::init8[]
@higherkind
sealed // - not possible with higherkind (tp)
class ListK<out A> : ListKOf<A> {
    fun <B> foldRight(z: B, f: (A, B) -> B): B = TODO()
}
//end::init8[]
