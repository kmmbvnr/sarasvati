/*
    This file is part of Sarasvati.

    Sarasvati is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    Sarasvati is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with Sarasvati.  If not, see <http://www.gnu.org/licenses/>.

    Copyright 2008 Paul Lorenz
*/
package com.googlecode.sarasvati;

import junit.framework.Assert;

public class TestToken<T extends Token>
{
  protected int           lineNumber;
  protected ExecutionType executionType;
  protected T             token;
  protected boolean       complete;

  protected boolean isValidated = false;

  public TestToken (int lineNumber, boolean complete, ExecutionType executionType)
  {
    this.lineNumber = lineNumber;
    this.complete   = complete;
    this.executionType = executionType;
  }

  public int getLineNumber ()
  {
    return lineNumber;
  }

  public void setLineNumber (int lineNumber)
  {
    this.lineNumber = lineNumber;
  }

  public boolean isComplete ()
  {
    return complete;
  }

  public void setComplete (boolean complete)
  {
    this.complete = complete;
  }

  public ExecutionType getExecutionType ()
  {
    return executionType;
  }

  public void setExecutionType (ExecutionType executionType)
  {
    this.executionType = executionType;
  }

  public T getToken ()
  {
    return token;
  }

  public void setToken (T token)
  {
    this.token = token;
  }


  public boolean isValidated ()
  {
    return isValidated;
  }

  public void setValidated (boolean isValidated)
  {
    this.isValidated = isValidated;
  }

  public void validate ()
  {
    Assert.assertEquals( "Execution type does not match on " + toString(), executionType, token.getExecutionType() );
    Assert.assertEquals( "IsComplete? does not match on " + toString(), complete, token.isComplete() );
    isValidated = true;
  }
}