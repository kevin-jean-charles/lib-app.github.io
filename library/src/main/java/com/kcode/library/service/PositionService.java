package com.kcode.library.service;

import com.kcode.library.model.Position;

public interface PositionService {

    //create position
    Position createPosition(Position position);

    //change position
    Position changePosition(Position position);

}
