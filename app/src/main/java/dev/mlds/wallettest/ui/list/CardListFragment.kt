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
                        backClick = ::backClick
                    )
//                    CardList(
//                        CardsModel(
//                            cards = listOf(
//                                CardModel(
//                                    id = "",
//                                    number = "**** **** **** 3727",
//                                    cvv = "1234",
//                                    name = "João Carlos Pereira",
//                                    validade = "06/29",
//                                    color = CardModel.CardType.GREEN
//                                ),
//                                CardModel(
//                                    id = "",
//                                    number = "**** **** **** 3727",
//                                    cvv = "1234",
//                                    name = "João Carlos Pereira",
//                                    validade = "06/29",
//                                    color = CardModel.CardType.BLACK
//                                )
//                            )
//                        )
//                    )
                }
            }
        }
    }

    private fun backClick() {
        findNavController().popBackStack()
    }
}