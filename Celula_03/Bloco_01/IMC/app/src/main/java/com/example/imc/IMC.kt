import android.os.Parcel
import android.os.Parcelable

class IMC(private var nome: String?, private var peso: Float, private var altura: Float, var imc: Float = 0.0f) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat()
    )

    // Métodos de acesso para peso e altura
    fun getPeso(): Float {
        return peso
    }

    fun getAltura(): Float {
        return altura
    }

    constructor(nome: String, peso: Float, altura: Float) : this(nome, peso, altura, 0.0f) {
        calcularIMC() // Calcular o IMC ao criar uma instância
    }

    fun getNome(): String? {
        return nome
    }

    fun calcular(): String {
        // Método para calcular o estado de saúde
        return when (imc) {
            in 0.0..16.0 -> "Magreza grave"
            in 16.0..17.0 -> "Magreza moderada"
            in 17.0..19.0 -> "Magreza leve"
            in 19.0..25.0 -> "Saudável"
            in 25.0..30.0 -> "Sobrepeso"
            in 30.0..35.0 -> "Obesidade I"
            in 35.0..40.0 -> "Obesidade II"
            else -> "Obesidade Mórbida."
        }
    }

    private fun calcularIMC() {
        // Calcular o IMC com base no peso e altura
        val alturaMetros = altura / 100
        imc = peso / (alturaMetros * alturaMetros)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeFloat(peso)
        parcel.writeFloat(altura)
        parcel.writeFloat(imc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IMC> {
        override fun createFromParcel(parcel: Parcel): IMC {
            return IMC(parcel)
        }

        override fun newArray(size: Int): Array<IMC?> {
            return arrayOfNulls(size)
        }
    }
}
