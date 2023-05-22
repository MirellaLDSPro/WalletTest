package dev.mlds.wallettest.ui.commons

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment: Fragment() {

    protected abstract fun nextPageClick()
    protected fun backClick() {
        findNavController().popBackStack()
    }
}