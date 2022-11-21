package com.ulbra.controlelivros.data.data_source.dao

import com.ulbra.controlelivros.domain.model.Book
import io.realm.Realm
import io.realm.Sort

object BookDAO : BaseDao<Int, Book> {

    override fun save(aObject: Book) : Int {
        var lId = 1
        val realm = Realm.getDefaultInstance()
        try {
            val maxId = realm.where(Book::class.java).max("_id")
            val nextId = if (maxId == null) 1 else maxId.toInt() + 1
            aObject._id = nextId
            realm.beginTransaction()
            val transaction = realm.copyToRealmOrUpdate(aObject)
            lId = transaction?._id!!
            realm.commitTransaction()
        } catch (ex : Exception) {
            ex.printStackTrace()
        } finally {
            realm.close()
        }
        return lId
    }

    override fun update(aObject: Book) : Int {
        var lId = 1
        val realm = Realm.getDefaultInstance()
        try {
            realm.beginTransaction()
            val transaction = realm.copyToRealmOrUpdate(aObject)
            lId = transaction?._id!!
            realm.commitTransaction()
        } catch (ex : Exception) {
            ex.printStackTrace()
        } finally {
            realm.close()

        }
        return lId
    }

    override fun loadAll() : MutableList<Book>? {
        var list : MutableList<Book>? = null
        val realm = Realm.getDefaultInstance()
        try {
            val realInfos = realm.where(Book::class.java).sort("_id", Sort.ASCENDING).findAll()
            list = realm.copyFromRealm(realInfos)
        } catch (ex : Exception) {
            ex.printStackTrace()
        } finally {
            realm.close()
        }
        return list
    }

    override fun deleteById(id : Int) {
        val realm = Realm.getDefaultInstance()
        try {
            val monitoring = realm.where(Book::class.java).equalTo("_id", id).findFirst()
            realm.beginTransaction()
            monitoring?.deleteFromRealm()
            realm.commitTransaction()
        } catch (ex : Exception) {
            ex.printStackTrace()
        } finally {
            realm.close()
        }
    }

    override fun loadById(id: Int): Book? {
        TODO("Not yet implemented")
    }

    fun loadAllNotRead() : MutableList<Book>? {
        var list : MutableList<Book>? = null
        val realm = Realm.getDefaultInstance()
        try {
            val realInfos = realm.where(Book::class.java).equalTo("isRead", false).sort("_id", Sort.ASCENDING).findAll()
            list = realm.copyFromRealm(realInfos)
        } catch (ex : Exception) {
            ex.printStackTrace()
        } finally {
            realm.close()
        }
        return list
    }

    fun loadAllRead() : MutableList<Book>? {
        var list : MutableList<Book>? = null
        val realm = Realm.getDefaultInstance()
        try {
            val realInfos = realm.where(Book::class.java).equalTo("isRead", true).sort("_id", Sort.ASCENDING).findAll()
            list = realm.copyFromRealm(realInfos)
        } catch (ex : Exception) {
            ex.printStackTrace()
        } finally {
            realm.close()
        }
        return list
    }
}