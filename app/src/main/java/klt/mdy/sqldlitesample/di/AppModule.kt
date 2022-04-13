package klt.mdy.sqldlitesample.di

import android.app.Application
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import klt.mdy.sqldlitesample.UserDatabase
import klt.mdy.sqldlitesample.repo.Repository
import klt.mdy.sqldlitesample.repo.RepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesSqlDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = UserDatabase.Schema,
            context = app,
            name = "user.db"
        )
    }

    @Provides
    @Singleton
    fun providesRepo(driver: SqlDriver): Repository {
        return RepositoryImpl(
            db = UserDatabase(driver = driver)
        )
    }
}