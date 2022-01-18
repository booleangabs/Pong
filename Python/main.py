# -*- coding: utf-8 -*-
"""
Created on Mon Jan 17 22:17:36 2022

@author: booleangabs
"""

# site-packages
import pygame as pgm

# native 
import time

# local
from players import Player
from constants import Constants

class Pong:
    def __init__(self):
        self.player = Player()
        pgm.init()
        self.screen = pgm.display.set_mode(Constants.WINDOW_SHAPE)
        self.screen.fill(Constants.COLOR_BLACK)
        pgm.display.set_caption(Constants.WINDOW_TITLE)
        pgm.display.set_icon(Constants.WINDOW_ICON)
    
    def run(self):
        print("Game started")
        done = False
        while not done:
            self.draw()
            
            for event in pgm.event.get():
                if event.type == pgm.QUIT:
                    done = True
            
                if event.type == pgm.KEYDOWN:
                    if event.key == pgm.K_ESCAPE:
                        done = True
                    
    def draw(self):
        self.screen.fill(Constants.COLOR_BLACK)

if __name__ == "__main__":
    try:
        Pong().run()
    except:
        pgm.quit()