// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//This is code for a custom arcade machine, you can change anything to your need

package edu.wpi.first.wpilibj;

import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.event.BooleanEvent;
import edu.wpi.first.wpilibj.event.EventLoop;

/**
 * Handle input from Arcade Joystick and buttons connected to the Driver Station.
 *
 * <p>This class handles input that comes from the Driver Station. Each time a value is
 * requested the most recent value is returned. There is a single class instance for each controller
 * and the mapping of ports to hardware buttons depends on the code in the Driver Station.
 */

public class ArcadeController extends GenericHID {

 /** Represents a digital button on an Arcade Controller. */
    public enum ArcadeButton{
        //Values found by using driverstation and looking at inputs. Each rectangle is a different value.
        kOne(1),
        kTestButtonTwo(2),
        kTestButtonThree(3),
        kTestButtonFour(4),
        kTestButtonFive(5),
        kTestButtonSix(6),
        kTestButtonSeven(7),
        kTestButtonEight(8),
        kTestButtonNine(9),
        kTestButtonTen(10),
        kTestButtonEleven(11),
        kTestButtonTwelve(12);

        public final int value;

        ArcadeButton(int value) {
        this.value = value;
        }


        /**
         * Get the human-friendly name of the button, matching the relevant methods. This is done by
         * stripping the leading `k`, and if not a Bumper button append `Button`.
         *
         * <p>Primarily used for automated unit tests.
         *
         * @return the human-friendly name of the button.
         */
        @Override
        public String toString() {
        var name = this.name().substring(1); // Remove leading `k`
        if (name.endsWith("Bumper")) {
            return name;
        }
        return name + "Button";
        }
    }
    
  /** Represents an axis on an Arcade Controller. */
  public enum Axis {
    
    // Find value by looking at number in driverstation inputs
    kXAxis(0),
    kYAxis(1);
    public final int value;

    Axis(int value) {
      this.value = value;
    }

    /**
     * Get the human-friendly name of the axis, matching the relevant methods. This is done by
     * stripping the leading `k`, and if a trigger axis append `Axis`.
     *
     * <p>Primarily used for automated unit tests.
     *
     * @return the human-friendly name of the axis.
     */
    @Override
    public String toString() {
      var name = this.name().substring(1); // Remove leading `k`
      if (name.endsWith("Trigger")) {
        return name + "Axis";
      }
      return name;
    }
  }
  /**
   * Construct an instance of a controller.
   *
   * @param port The port index on the Driver Station that the controller is plugged into.
   */
  public ArcadeController(final int port) {
    super(port);
    //Report does not seem to matter
    //if you need to change it, look at the list in the definition of the resource type
    HAL.report(tResourceType.kResourceType_Controller, port + 1);
  }

  /**
   * Get the X axis value of the controller.
   *
   * @return The axis value.
   */
  public double getXAxis() {
    return getRawAxis(Axis.kXAxis.value);
  }
  /**
   * Get the Y axis value of the controller.
   *
   * @return The axis value.
   */
  public double getLeftY() {
    return getRawAxis(Axis.kYAxis.value);
  }

  /**
   * Read the value of the First Button on the controller.
   *
   * @return The state of the button.
   */
  public boolean getFirstButton() {
    return getRawButton(ArcadeButton.kOne.value);
  }

  /**
   * Whether the First Button was pressed since the last check.
   *
   * @return Whether the button was pressed since the last check.
   */
  public boolean getFirstButtonPressed() {
    return getRawButtonPressed(ArcadeButton.kOne.value);
  }

  /**
   * Whether the First Button was released since the last check.
   *
   * @return Whether the button was released since the last check.
   */
  public boolean getFirstButtonReleased() {
    return getRawButtonReleased(ArcadeButton.kOne.value);
  }



  /**
   * Constructs an event instance around the Ninth Button's digital signal.
   *
   * @param loop the event loop instance to attach the event to.
   * @return an event instance representing the Ninth Button's digital signal attached to the given
   *     loop.
   */
  @SuppressWarnings("MethodName")
  public BooleanEvent Ninth(EventLoop loop) {
    return new BooleanEvent(loop, this::getAButton);
  }
    /**
   * Read the value of the Ninth Button on the controller.
   *
   * @return The state of the button.
   */
  public boolean getAButton() {
    return getRawButton(ArcadeButton.kOne.value);
  }

  /**
   * Whether the Ninth Button was pressed since the last check.
   *
   * @return Whether the button was pressed since the last check.
   */
  public boolean getAButtonPressed() {
    return getRawButtonPressed(ArcadeButton.kOne.value);
  }

  /**
   * Whether the Ninth Button was released since the last check.
   *
   * @return Whether the button was released since the last check.
   */
  public boolean getninthButtonReleased() {
    return getRawButtonReleased(ArcadeButton.kOne.value);
  }

  /**
   * Constructs an event instance around the Ninth Button's digital signal.
   *
   * @param loop the event loop instance to attach the event to.
   * @return an event instance representing the Ninth Button's digital signal attached to the given
   *     loop.
   */
  @SuppressWarnings("MethodName")
  public BooleanEvent Nine(EventLoop loop) {
    return new BooleanEvent(loop, this::getAButton);
  }

}
