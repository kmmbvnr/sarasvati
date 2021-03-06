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

    Copyright 2009 Paul Lorenz
*/
package com.googlecode.sarasvati;


/**
 * Encapsulates a strategy for determining if a node is ready to execute. A JoinStrategy
 * will be executed whenever an {@link ArcToken} is processed. The join strategy will
 * determine if a NodeToken will be created or if the ArcToken will be added to the list
 * of active arc tokens.
 *
 * @author Paul Lorenz
 */
public interface JoinStrategy
{
  /**
   * Called on every {@link ArcToken} when processed.
   *
   * @param The engine executing the given process.
   * @param process The process being executed.
   * @param token The arc token being processed.
   *
   * @return The {@link JoinResult} encapsulating if the join is complete and the set of
   *         arc tokens participating in the join.
   */
  JoinResult performJoin (Engine engine, GraphProcess process, ArcToken token);
}
