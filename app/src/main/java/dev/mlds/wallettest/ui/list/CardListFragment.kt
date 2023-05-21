package dev.mlds.wallettest.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.mlds.wallettest.databinding.FragmentCardListBinding
import dev.mlds.wallettest.ui.theme.WalletLigthTheme

class CardListFragment : Fragment() {

    private lateinit var viewBinding: FragmentCardListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentCardListBinding.inflate(layoutInflater)
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                WalletLigthTheme {
                    CardListScreen(
                        backClick = ::backClick
                    )
                }
            }
        }
    }

    private fun backClick() {
        findNavController().popBackStack()
    }
}