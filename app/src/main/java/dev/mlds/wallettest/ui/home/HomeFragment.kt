package dev.mlds.wallettest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.mlds.wallettest.R
import dev.mlds.wallettest.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
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
                    openList = ::openListScreen,
                    openCreate = ::openCreateScreen
                )
            }
        }
    }

    private fun openListScreen() {
        findNavController().navigate(R.id.action_homeFragment_to_cardListFragment)
    }

    private fun openCreateScreen() {
        findNavController().navigate(R.id.action_homeFragment_to_createCardFragment)
    }
}