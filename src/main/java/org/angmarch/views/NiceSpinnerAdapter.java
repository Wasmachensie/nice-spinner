package org.angmarch.views;

import android.content.Context;

import java.util.List;

/*
 * Copyright (C) 2015 Angelo Marchesin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class NiceSpinnerAdapter<T> extends NiceSpinnerBaseAdapter {

    private final List<T> list;

    NiceSpinnerAdapter(
            Context context,
            List<T> list,
            int textColor,
            int backgroundSelector,
            SpinnerTextFormatter spinnerTextFormatter
    ) {
        super(context, textColor, backgroundSelector, spinnerTextFormatter);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size() - 1;
    }

    @Override
    public T getItem(int position) {
        return list.get(getAdjustedPosition(position));
    }

    @Override
    public T getItemInDataset(int position) {
        return list.get(position);
    }

    @Override
    public int getAdjustedPosition(int position) {
        if (position >= selectedIndex) {
            return position + 1;
        } else {
            return position;
        }
    }
}