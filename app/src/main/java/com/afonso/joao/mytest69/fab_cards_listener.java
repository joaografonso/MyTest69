package com.afonso.joao.mytest69;

import android.support.annotation.NonNull;
import android.view.View;

import com.dexafree.materialList.card.Action;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.card.OnActionClickListener;
import com.dexafree.materialList.card.action.TextViewAction;
import com.dexafree.materialList.view.MaterialListView;

/**
 * Created by joao on 03/11/15.
 */
public class fab_cards_listener implements View.OnClickListener {

    private MaterialListView mListView;

    public fab_cards_listener(MaterialListView mListView) {
        this.mListView = mListView;
    }


    @Override
    public void onClick(View v) {
        //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //          .setAction("Action", null).show();

        Card card = new Card.Builder(v.getContext())
                .setTag("BASIC_IMAGE_BUTTONS_CARD")
                .setDismissible()
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_basic_image_buttons_card_layout)
                .setTitle("Hi there")
                .setDescription("I've been added on top!")
                .addAction(R.id.left_text_button, new TextViewAction(v.getContext())
                        .setText("left")
                        .setTextResourceColor(R.color.black_button))
                .addAction(R.id.right_text_button, new TextViewAction(v.getContext()).setListener(new OnActionClickListener() {
                    @Override
                    public void onActionClicked(View view, Card card) {
                        System.out.println("TESTE");
                    }
                }).setText("TESTE").setTextResourceColor(R.color.black_button))

                        //new TextViewAction(v.getContext())
                        //.setText("right")
                        //.setTextResourceColor(R.color.orange_button)

                .setDrawable(R.drawable.sample_android)
                .endConfig()
                .build();



        mListView.setClickable(true);
        mListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("CLICKED CARD");
            }
        });

        mListView.getAdapter().add(card);

    }
}
