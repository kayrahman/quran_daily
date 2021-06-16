package com.nkr.qurandaily

import android.app.Application
import com.nkr.qurandaily.repo.remote.IRemoteDataSource
import com.nkr.qurandaily.repo.remote.RemoteDataSourceImpl
import com.nkr.qurandaily.ui.fragment.chapterList.ChapterListViewModel
import com.nkr.qurandaily.ui.fragment.chapterDetail.ChapterDetailViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        /**
         * use Koin Library as a service locator
         */
        val myModule = module {
            //Declare a ViewModel - be later inject into Fragment with dedicated injector using by viewModel()


            viewModel {
                ChapterListViewModel(
                    this@App,
                    get() as IRemoteDataSource
                )
            }

            viewModel {
                ChapterDetailViewModel(
                    this@App,
                    get() as IRemoteDataSource
                )
            }


            //  single { MyFirebaseMessagingService(get() as IRepoDataSource) }
       //     single { SharedPrefsHelper(this@App) }
        //    single { BazarAnoRepository(get() as ILocalDataSource,get() as IRemoteDataSource) as IRepoDataSource }
            single { RemoteDataSourceImpl() as IRemoteDataSource }
         //   single { LocalDataSourceImpl(get()) as ILocalDataSource }
          //  single { BazarAnoLocalDatabase.getInstance(this@App).productDao }
            // single { RemindersLocalRepository(get())}
        }

        startKoin {
            androidContext(this@App)
            modules(listOf(myModule))
        }


    }
}