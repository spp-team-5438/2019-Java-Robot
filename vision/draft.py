import cv2
import numpy as np

import sys
import time
import logging

# post to networktables
# use threading to make faster
# fix exposure to make more acccurate

camera = cv2.VideoCapture(0)
camera.set(cv2.CAP_PROP_FRAME_WIDTH, 320)
camera.set(cv2.CAP_PROP_FRAME_HEIGHT, 240)



currentFrame = 0
while(True):
    # capture each framee
    ret, frame = camera.read()
    blurred = cv2.GaussianBlur(frame, (5, 5), 0) # test to see if this works better
    hsv = cv2.cvtColor(blurred, cv2.COLOR_RGB2HSV)

    # range of reflective color (white to gray for now)
    lower = np.array([0,0,75])
    upper = np.array([128,128,128])

    mask = cv2.inRange(hsv, lower, upper)
    res = cv2.bitwise_and(frame,frame,mask = mask)

    img, contours, hierarchy = cv2.findContours(mask, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    cv2.drawContours(frame, contours, -1, (255,0,0), 3)

    # display  resulting frame
    cv2.imshow('frame', frame)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

    currentFrame += 1

camera.release()
cv2.destroyAllWindows()
