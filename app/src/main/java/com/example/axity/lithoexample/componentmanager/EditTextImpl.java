package com.example.axity.lithoexample.componentmanager;

import com.example.axity.lithoexample.components.EditTextComponent;
import com.example.axity.lithoexample.utils.Constants;
import com.example.axity.lithoexample.utils.JsonManager;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;

/**
 * Created by javierrodriguez on 4/9/18.
 */

public class EditTextImpl implements  IComponentChain{

    private IComponentChain chain;

    @Override
    public void setNextChain(IComponentChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(ComponentContext c, Column.Builder builder, String data) {

        JsonManager manager = new JsonManager(data).parse();

        if(manager.getChild(Constants.ELEMENTS_TYPE).equals(Constants.CHAIN_EDITTEXT)){
            builder.child(
                EditTextComponent.create(c)
                .id(manager.getChild(Constants.ELEMENTS_ID))
                .hint(manager.getChild(Constants.ELEMENTS_HINT))
                .title(manager.getChild(Constants.ELEMENTS_HINT))
                .build());
        }else{
            this.chain.dispense(c, builder, data);
        }
    }
}
