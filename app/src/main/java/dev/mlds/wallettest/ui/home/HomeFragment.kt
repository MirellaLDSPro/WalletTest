package dev.mlds.wallettest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import dev.mlds.wallettest.R
import dev.mlds.wallettest.databinding.FragmentHomeBinding
import dev.mlds.wallettest.ui.commons.BaseFragment

class HomeFragment : BaseFragment() {
    private lateinit var viewBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHomeBinding.inflate(layoutInflater)
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                HomeScreen(
                    openList = { openScreen(navigationId = R.id.action_homeFragment_to_cardListFragment) },
                    openCreate = { openScreen(navigationId = R.id.action_homeFragment_to_createCardFragment) }
                )
            }
        }
    }
}