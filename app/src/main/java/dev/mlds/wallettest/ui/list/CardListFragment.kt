package dev.mlds.wallettest.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.mlds.wallettest.R
import dev.mlds.wallettest.databinding.FragmentCardListBinding
import dev.mlds.wallettest.domain.models.CardModel
import dev.mlds.wallettest.domain.models.CardsModel
import dev.mlds.wallettest.ui.test.CardList
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
                        backClick = ::backClick,
                        createClick = ::nextPageClick
                    )
                }
            }
        }
    }

    private fun nextPageClick() {
        findNavController().navigate(R.id.action_cardListFragment_to_createCardFragment)
    }

    private fun backClick() {
        findNavController().popBackStack()
    }
}