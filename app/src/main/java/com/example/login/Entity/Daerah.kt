package com.example.login.Entity

class Daerah (var name: String, est_ongkir: Int) {

    companion object {
        @JvmField
        var listOfDaerah = arrayOf(
            Daerah("Bali",300000),
            Daerah("Yogyakarta",400000),
            Daerah("Jakarta",500000),
            Daerah("Bandung",600000),
            Daerah("Surabaya",700000),
            Daerah("Batam",800000),
            Daerah("Semarang",900000),
            Daerah("Samarinda",1000000),
            Daerah("Medan",1100000),
            Daerah("Aceh",1200000)
        )
    }
}