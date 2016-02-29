/*
 * Copyright 2015 Nokia Solutions and Networks
 * Licensed under the Apache License, Version 2.0,
 * see license.txt file for details.
 */
package org.rf.ide.core.testdata.model.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.rf.ide.core.testdata.model.RobotFile;
import org.rf.ide.core.testdata.model.table.keywords.UserKeyword;

public class KeywordTable extends ARobotSectionTable {

    private final List<UserKeyword> userKeywords = new ArrayList<>();

    public KeywordTable(final RobotFile parent) {
        super(parent);
    }

    public void addKeyword(final UserKeyword keyword) {
        keyword.setParent(this);
        userKeywords.add(keyword);
    }

    public void addKeyword(final UserKeyword keyword, final int position) {
        keyword.setParent(this);
        userKeywords.set(position, keyword);
    }

    public void removeKeyword(final UserKeyword keyword) {
        userKeywords.remove(keyword);
    }

    public boolean moveUpKeyword(final UserKeyword keyword) {
        return getMoveHelper().moveUp(userKeywords, keyword);
    }

    public boolean moveDownKeyword(final UserKeyword keyword) {
        return getMoveHelper().moveDown(userKeywords, keyword);
    }

    public List<UserKeyword> getKeywords() {
        return Collections.unmodifiableList(userKeywords);
    }

    public boolean isEmpty() {
        return (userKeywords.isEmpty());
    }
}
