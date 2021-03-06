package uz.behzoddev.restaurantpos.data.repositories

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.datasource.ItemDataSource
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.di.annotations.DatasourceBinds
import uz.behzoddev.restaurantpos.domain.repositories.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    @DatasourceBinds private val itemDataSource: ItemDataSource
) : ItemRepository {
    override suspend fun insertFoodItem(foodItem: FoodItem): Long {
        return itemDataSource.insertFoodItem(foodItem)
    }

    override suspend fun updateFoodItem(foodItem: FoodItem): Int {
        return itemDataSource.updateFoodItem(foodItem)
    }

    override suspend fun deleteFoodItem(foodItem: FoodItem): Int {
        return itemDataSource.deleteFoodItem(foodItem)
    }

    override fun fetchAllFoodItems(): Flow<List<FoodItem>> {
        return itemDataSource.fetchAllFoodItems()
    }

    override fun fetchAllFoodItemsByName(): Flow<List<FoodItem>> {
        return itemDataSource.fetchAllFoodItemsByName()
    }

    override fun fetchByColdBrew(): Flow<List<FoodItem>> {
        return itemDataSource.fetchByColdBrew()
    }

    override fun fetchByBrood(): Flow<List<FoodItem>> {
        return itemDataSource.fetchByBrood()
    }

    override fun fetchByEspresso(): Flow<List<FoodItem>> {
        return itemDataSource.fetchByEspresso()
    }

    override fun fetchByFrappucino(): Flow<List<FoodItem>> {
        return itemDataSource.fetchByFrappucino()
    }

    override fun fetchByBlended(): Flow<List<FoodItem>> {
        return itemDataSource.fetchByBlended()
    }

    override fun fetchByPhysio(): Flow<List<FoodItem>> {
        return itemDataSource.fetchByPhysio()
    }

    override fun fetchByTea(): Flow<List<FoodItem>> {
        return itemDataSource.fetchByTea()
    }

    override fun fetchByJuice(): Flow<List<FoodItem>> {
        return itemDataSource.fetchByJuice()
    }

    override fun fetchById(id: Long): Flow<FoodItem> {
        return itemDataSource.fetchById(id)
    }

    override suspend fun saveAllFoods(list: List<FoodItem>) {
        return itemDataSource.saveAllFoods(list)
    }
}