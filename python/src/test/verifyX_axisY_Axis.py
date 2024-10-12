def verifyX_axisY_Axis( driver: object,
                        x_axisOfElem: int,
                        expectedX_Axis: int,
                        y_axisOfElem: int,
                        expectedY_Axis: int) -> bool:

    try:
        assert x_axisOfElem == expectedX_Axis
        assert y_axisOfElem == expectedY_Axis
        return f"[INFO]: Asserts passed."
    except AssertionError as e:
        return f"[ERROR]: Assert failed {e}"


    
