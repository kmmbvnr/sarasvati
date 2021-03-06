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
package com.googlecode.sarasvati.visual;

import org.netbeans.api.visual.widget.Widget;

import com.googlecode.sarasvati.visual.process.SarasvatiProcessScene;
import com.googlecode.sarasvati.visual.process.VisualProcessNode;

/**
 * Controls how a graph will be drawn, including generating an appropriate {@link Widget}
 * for each {@link VisualProcessNode}.
 *
 * @author Paul Lorenz
 */
public interface ProcessLookAndFeel
{
  /**
   * Controls if self arcs should be drawn.
   *
   * @return True if self arcs should be drawn, false otherwise
   */
  boolean drawSelfArcs ();

  /**
   * Controls if arc labels should be drawn.
   *
   * @return True if arc labels should be drawn, false otherwise
   */
  boolean drawArcLabels ();

  /**
   * Controls if arc labels should be drawn.
   *
   * @return True if arc labels should be drawn, false otherwise
   */

  Widget newWidget (VisualProcessNode node, SarasvatiProcessScene scene);
}
