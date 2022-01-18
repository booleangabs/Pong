# -*- coding: utf-8 -*-
"""
Created on Mon Jan 17 22:21:07 2022

@author: Gabriel
"""

# site-packages
from pygame.image import load

# native
import enum
import os


class Constants:
    WINDOW_TITLE = "Pong - Python"
    WINDOW_ICON = load(os.path.join(os.path.dirname(__file__),
                                    "assets/images/icon.png"))
    WINDOW_SHAPE = (640, 480)
    COLOR_BLACK = [0, 0, 0]
    COLOR_WHITE = [255, 255, 255]