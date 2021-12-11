package com.eric.marvelapi.comics.data

import com.eric.marvelapi.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

open class Keys {

    companion object {

        private var timestamp = Date().time.toString()

        fun getApiKey() = BuildConfig.PUBLIC_API_KEY
        fun getTimeStamp() = timestamp

        fun getHash(): String {

            val md = MessageDigest.getInstance("MD5")
            val messageDigest =
                md.digest(
                    timestamp.toByteArray()
                            + BuildConfig.PRIVATE_API_KEY.toByteArray()
                            + BuildConfig.PUBLIC_API_KEY.toByteArray()
                )
            val bi = BigInteger(1, messageDigest)
            var hash = bi.toString(16)

            while (hash.length < 32) {
                hash = "0$hash"
            }
            return hash
        }
    }
}