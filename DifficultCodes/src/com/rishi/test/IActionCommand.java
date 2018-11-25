package com.rishi.test;

public interface IActionCommand
{
    void execute() ;
    void setReceiver( IActionListener target ) ;
}
