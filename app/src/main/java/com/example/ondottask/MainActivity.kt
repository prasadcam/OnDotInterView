package com.example.ondottask


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.an.biometric.BiometricCallback
import com.an.biometric.BiometricManager
import com.example.ondottask.view.PixaBayListView
import com.example.ondottask.viewModel.PixaBayListViewModel








class MainActivity : AppCompatActivity() ,BiometricCallback{
    override fun onBiometricAuthenticationNotSupported() {
        displatToast(this,R.string.biometric_error_hardware_not_supported,Toast.LENGTH_LONG)
    }

    override fun onBiometricAuthenticationNotAvailable() {
        displatToast(this,R.string.biometric_error_fingerprint_not_available,Toast.LENGTH_LONG)
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        displatToast(this,R.string.biometric_error_permission_not_granted,Toast.LENGTH_LONG)
    }

    override fun onBiometricAuthenticationInternalError(error: String?) {
        displatToast(this,R.string.biometric_failure,Toast.LENGTH_LONG)
    }

    override fun onAuthenticationFailed() {
        displatToast(this,R.string.biometric_failed,Toast.LENGTH_LONG)
    }

    override fun onAuthenticationCancelled() {
        Log.d("Main activity"," Biometric cancelled")
        directToPixaBayListView();

    }

    override fun onAuthenticationSuccessful() {
        Log.d("Main activity"," Biometric success")
        directToPixaBayListView();

    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
        displatToast(this,R.string.biometric_description,Toast.LENGTH_LONG)
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
        displatToast(this,R.string.biometric_failed,Toast.LENGTH_LONG)
    }

    override fun onSdkVersionNotSupported() {
        displatToast(this,R.string.biometric_error_sdk_not_supported,Toast.LENGTH_LONG)
    }


    var mBiometricManager: BiometricManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        onLoginClick();

    }

    fun displatToast(context:Context,str:Int,lenth:Int){

        runOnUiThread(Runnable {

            Toast.makeText(this,R.string.biometric_error_sdk_not_supported,Toast.LENGTH_LONG)
        })


    }

    override fun onStop() {
        super.onStop()
        mBiometricManager?.cancelAuthentication() ;
        mBiometricManager = null ;
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun onLoginClick(){

        mBiometricManager = BiometricManager.BiometricBuilder(this@MainActivity)
            .setTitle(getString(R.string.biometric_title))
            .setSubtitle(getString(R.string.biometric_subtitle))
            .setDescription(getString(R.string.biometric_description))
            .setNegativeButtonText(getString(R.string.biometric_negative_button_text))
            .build()

        //start authentication
        mBiometricManager?.authenticate(this@MainActivity)

    }

    fun directToPixaBayListView(){
        val intent = Intent(this, PixaBayListView::class.java)
        startActivity(intent)

    }
}
