package com.example.myroomfloria

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myroomfloria.advance.Dog4
import com.example.myroomfloria.advance.Owner4
import com.example.myroomfloria.manyToMany.Dog3
import com.example.myroomfloria.manyToMany.DogOwnerCrossRef
import com.example.myroomfloria.manyToMany.Owner3
import com.example.myroomfloria.oneToMany.Dog2
import com.example.myroomfloria.oneToMany.Owner2
import com.example.myroomfloria.oneToOneRelations.Dog1
import com.example.myroomfloria.oneToOneRelations.Owner1
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        oneToOne(this)
        oneToMany(this)
        manyToMany(this)
        advanced(this)
    }

    fun oneToOne(context: Context) {
        val sampleDatabaseDao = SampleDatabase.getInstance(this).dogAndOwnerDao
        val dogs = listOf(
            Dog1(0L, 0L, "Mike Litoris", 0, 0, "Litoris"),
            Dog1(1L, 1L, "Jack Goff", 1, 1, "Goff"),
            Dog1(2L, 2L, "Chris P. Chicken", 2, 2, "Chicken")
        )
        val owners = listOf(
            Owner1(0L, "Mike Litoris"),
            Owner1(1L, "Jack Goff"),
            Owner1(2L, "Chris P. Chicken")
        )

        lifecycleScope.launch {
            dogs.forEach { sampleDatabaseDao.insertDog(it) }
            owners.forEach { sampleDatabaseDao.insertOwner(it) }
            val dogAndOwner = sampleDatabaseDao.getDogsAndOwners()
            Log.d("MAINACTIVITY", "oneToOne:dogAndOwner $dogAndOwner ")
            //[
            // DogAndOwner(owner=Owner(ownerId=0, name=Mike Litoris), // dog=Dog(dogId=0, dogOwnerId=0, name=Mike Litoris, cuteness=0, barkVolume=0, breed=Litoris)),
            // DogAndOwner(owner=Owner(ownerId=1, name=Jack Goff), dog=Dog(dogId=1, dogOwnerId=1, name=Jack Goff, cuteness=1, barkVolume=1, breed=Goff)),
            // DogAndOwner(owner=Owner(ownerId=2, name=Chris P. Chicken), dog=Dog(dogId=2, dogOwnerId=2, name=Chris P. Chicken, cuteness=2, barkVolume=2, breed=Chicken))
            // ]
        }
    }

    fun oneToMany(context: Context) {
        val sampleDatabaseDao = SampleDatabase.getInstance(this).dog2AndOwner2Dao
        val dogs = listOf(
            Dog2(0L, 0L, "Mike Litoris", 0, 0, "Litoris"),
            Dog2(1L, 1L, "Jack Goff", 1, 1, "Goff"),
            Dog2(2L, 2L, "Chris P. Chicken", 2, 2, "Chicken"),
            Dog2(3L, 2L, "Chris G. Chicken", 2, 2, "Chicken"),
            Dog2(4L, 0L, "Chris H. Chicken", 2, 2, "Chicken"),
        )
        val owners = listOf(
            Owner2(0L, "Mike Litoris"),
            Owner2(1L, "Jack Goff"),
            Owner2(2L, "Chris P. Chicken")
        )

        lifecycleScope.launch {
            dogs.forEach { sampleDatabaseDao.insertDog(it) }
            owners.forEach { sampleDatabaseDao.insertOwner(it) }
            val dogAndOwner = sampleDatabaseDao.get()
            Log.d("MAINACTIVITY", "oneToMany:dogAndOwner $dogAndOwner ")
            //[
            // Owner2WithDogs2(owner=Owner2(ownerId=0, name=Mike Litoris), dogs=[Dog2(dogId=0, dogOwnerId=0, name=Mike Litoris, cuteness=0, barkVolume=0, breed=Litoris), Dog2(dogId=4, dogOwnerId=0, name=Chris H. Chicken, cuteness=2, barkVolume=2, breed=Chicken)]),
            // Owner2WithDogs2(owner=Owner2(ownerId=1, name=Jack Goff), dogs=[Dog2(dogId=1, dogOwnerId=1, name=Jack Goff, cuteness=1, barkVolume=1, breed=Goff)]),
            // Owner2WithDogs2(owner=Owner2(ownerId=2, name=Chris P. Chicken), dogs=[Dog2(dogId=2, dogOwnerId=2, name=Chris P. Chicken, cuteness=2, barkVolume=2, breed=Chicken), Dog2(dogId=3, dogOwnerId=2, name=Chris G. Chicken, cuteness=2, barkVolume=2, breed=Chicken)])]
        }
    }

    fun manyToMany(context: Context) {
        val sampleDatabaseDao = SampleDatabase.getInstance(this).dog3AndOwner3Dao
        val dogs = listOf(
            Dog3(0L, 0L, "Mike Litoris", 0, 0, "Litoris"),
            Dog3(1L, 1L, "Jack Goff", 1, 1, "Goff"),
            Dog3(2L, 2L, "Chris P. Chicken", 2, 2, "Chicken"),
            Dog3(3L, 2L, "Chris G. Chicken", 2, 2, "Chicken"),
            Dog3(4L, 0L, "Chris H. Chicken", 2, 2, "Chicken"),
        )
        val owners = listOf(
            Owner3(0L, "Mike Litoris"),
            Owner3(1L, "Jack Goff"),
            Owner3(2L, "Chris P. Chicken")
        )

        lifecycleScope.launch {
            dogs.forEach { sampleDatabaseDao.insertDog(it) }
            owners.forEach { sampleDatabaseDao.insertOwner(it) }
            val ownersDogsRelations = listOf(
                DogOwnerCrossRef(0L, 0L),
                DogOwnerCrossRef(1L, 1L),
                DogOwnerCrossRef(2L, 2L),
                DogOwnerCrossRef(3L, 2L),
                DogOwnerCrossRef(4L, 0L),
                DogOwnerCrossRef(4L, 1L),
            )
            ownersDogsRelations.forEach { sampleDatabaseDao.insertOwnerDogCrossRef(it) }
            val dogAndOwner = sampleDatabaseDao.get()

            Log.d("MAINACTIVITY", "manyToMany:dogAndOwner $dogAndOwner ")
            //[
            // Owner3WithDogs3(owner=Owner3(ownerId=0, name=Mike Litoris), dogs=[Dog3(dogId=0, dogOwnerId=0, name=Mike Litoris, cuteness=0, barkVolume=0, breed=Litoris), Dog3(dogId=4, dogOwnerId=0, name=Chris H. Chicken, cuteness=2, barkVolume=2, breed=Chicken)]),
            // Owner3WithDogs3(owner=Owner3(ownerId=1, name=Jack Goff), dogs=[Dog3(dogId=1, dogOwnerId=1, name=Jack Goff, cuteness=1, barkVolume=1, breed=Goff)]),
            // Owner3WithDogs3(owner=Owner3(ownerId=2, name=Chris P. Chicken), dogs=[Dog3(dogId=2, dogOwnerId=2, name=Chris P. Chicken, cuteness=2, barkVolume=2, breed=Chicken), Dog3(dogId=3, dogOwnerId=2, name=Chris G. Chicken, cuteness=2, barkVolume=2, breed=Chicken)])]
        }
    }

    fun advanced(context: Context) {
        val sampleDatabaseDao = SampleDatabase.getInstance(this).dog4AndPupsDao
        val dogs = listOf(
            Dog4(0L, 0L, "Mike Litoris", 0, 0, "Litoris"),
            Dog4(1L, 1L, "Jack Goff", 1, 1, "Goff"),
            Dog4(2L, 2L, "Chris P. Chicken", 2, 2, "Chicken"),
            Dog4(3L, 2L, "Chris G. Chicken", 2, 2, "Chicken"),
            Dog4(4L, 0L, "Chris H. Chicken", 2, 2, "Chicken"),
        )
        val owners = listOf(
            Owner4(0L, "Mike Litoris"),
            Owner4(1L, "Jack Goff"),
            Owner4(2L, "Chris P. Chicken")
        )

        lifecycleScope.launch {
            dogs.forEach { sampleDatabaseDao.insertDog(it) }
            owners.forEach { sampleDatabaseDao.insertOwner(it) }

            val dogAndOwner = sampleDatabaseDao.get()
            val dogOwner = sampleDatabaseDao.getOwner()

            Log.d("MAINACTIVITY", "advanced:dogAndOwner $dogAndOwner ")
// [OwnerWithPups(owner=Owner4(ownerId=0, name=Mike Litoris), dogs=[Pup(name=Mike Litoris, cuteness=0), Pup(name=Chris H. Chicken, cuteness=2)]),
            // OwnerWithPups(owner=Owner4(ownerId=1, name=Jack Goff), dogs=[Pup(name=Jack Goff, cuteness=1)]),
            // OwnerWithPups(owner=Owner4(ownerId=2, name=Chris P. Chicken), dogs=[Pup(name=Chris P. Chicken, cuteness=2), Pup(name=Chris G. Chicken, cuteness=2)])]

            Log.d("MAINACTIVITY", "advanced:dogOwner $dogOwner ")
// [OwnerWithDogs(owner=Owner4(ownerId=0, name=Mike Litoris), dogNames=[Mike Litoris, Chris H. Chicken]), OwnerWithDogs(owner=Owner4(ownerId=1, name=Jack Goff), dogNames=[Jack Goff]), OwnerWithDogs(owner=Owner4(ownerId=2, name=Chris P. Chicken), dogNames=[Chris P. Chicken, Chris G. Chicken])] 
        }
    }
}