package com.joao.adivinha2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random.Default.nextInt


class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun conferir(view: View) {
        val random = (0..10).random().toString()
        val entrada: String = entradaValor.text.toString()
        if (entrada.equals(random)) {
            this.resultado.text = """Você acertou"""
            this.resultado2.text = " "
        }
        else {
            resultado2.text = "Vc errou, o número era: "
            resultado.text = random
        }

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }


        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }

    }

}


