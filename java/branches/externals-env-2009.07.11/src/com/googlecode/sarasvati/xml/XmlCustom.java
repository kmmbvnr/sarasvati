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
package com.googlecode.sarasvati.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;

import com.googlecode.sarasvati.load.definition.CustomDefinition;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmlCustom implements CustomDefinition
{
  @XmlAnyElement(lax = true)
  protected List<Object> custom;

  @Override
  public List<Object> getCustom ()
  {
    return custom;
  }

  public void setCustom (List<Object> custom)
  {
    this.custom = custom;
  }

  @Override
  public String toString ()
  {
    StringBuilder buf = new StringBuilder();
    buf.append( "<custom>\n" );

    if (custom != null)
    {
      buf.append( custom );
      buf.append( "\n" );
    }

    buf.append( "</custom>" );
    return buf.toString();
  }
}
