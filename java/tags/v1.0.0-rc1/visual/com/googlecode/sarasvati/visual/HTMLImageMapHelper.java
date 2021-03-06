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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.netbeans.api.visual.widget.Widget;

import com.googlecode.sarasvati.Graph;
import com.googlecode.sarasvati.GraphProcess;
import com.googlecode.sarasvati.adapter.Function;
import com.googlecode.sarasvati.visual.graph.SarasvatiGraphScene;
import com.googlecode.sarasvati.visual.process.SarasvatiProcessScene;

/**
 * Utility class to help generating HTML Image maps of graphs and processes.
 *
 * @author Paul Lorenz
 */
public class HTMLImageMapHelper
{
  /**
   * Generates the contents of an HTML image map. The results must still be
   * wrapped in a &lt;map&gt; element.
   *
   * <pre>
   *   Graph graph = ...;
   *   String result = HTMLImageMapHelper.exportToImageMap( graph,
   *                                                        widgetFactory,
   *                                                        hrefMapper,
   *                                                        titleMapper,
   *                                                        "/path/to/file.gif" );
   *   String map = "&lt;map name=\"graph\"&gt;" + result + "&lt;/map&gt;";
   * </pre>
   *
   * @param graph The graph to export
   * @param widgetFactory The Factory to use to generate Widgets for Nodes.
   * @param hrefMapper The function to use to generate clickable links for nodes
   * @param titleMapper The function to use to generate hovers for nodes
   * @param gifFileName The file in which to put the generated .gif.
   *
   * @return The contents of an HTML image map.
   *
   * @throws IOException
   */
  public static String exportToImageMap (Graph graph,
                                         NodeWidgetFactory widgetFactory,
                                         Function<String, Widget> hrefMapper,
                                         Function<String, Widget> titleMapper,
                                         String gifFileName)
    throws IOException
  {
    SarasvatiGraphScene graphScene = new SarasvatiGraphScene( graph, widgetFactory, false );
    graphScene.setupForExportOnHeadless();

    StringBuilder buf = new StringBuilder( 1024 );
    BufferedImage image = graphScene.export( buf, hrefMapper, titleMapper );
    ImageIO.write( image, "gif", new File( gifFileName ) );
    image.flush();

    return buf.toString();
  }

  /**
   * Generates the contents of an HTML image map. The results must still be
   * wrapped in a &lt;map&gt; element.
   *
   * <pre>
   *   GraphProcess process = ...;
   *   String result = HTMLImageMapHelper.exportToImageMap( process,
   *                                                        widgetFactory
   *                                                        hrefMapper,
   *                                                        titleMapper,
   *                                                        "/path/to/file.gif" );
   *   String map = "&lt;map name=\"graph\"&gt;" + result + "&lt;/map&gt;";
   * </pre>
   *
   * @param process The graph process to export
   * @param widgetFactory The Factory to use to generate Widgets for ProcessTreeNodes.
   * @param hrefMapper The function to use to generate clickable links for nodes
   * @param titleMapper The function to use to generate hovers for nodes
   * @param gifFileName The file in which to put the generate .gif.
   *
   * @return The contents of an HTML image map.
   *
   * @throws IOException
   */
  public static String exportToImageMap (GraphProcess process,
                                         ProcessTreeNodeWidgetFactory widgetFactory,
                                         Function<String, Widget> hrefMapper,
                                         Function<String, Widget> titleMapper,
                                         String gifFileName)
    throws IOException
  {
    SarasvatiProcessScene graphScene = new SarasvatiProcessScene( process, widgetFactory, false );
    graphScene.setupForExportOnHeadless();

    StringBuilder buf = new StringBuilder( 1024 );
    BufferedImage image = graphScene.export( buf, hrefMapper, titleMapper );
    ImageIO.write( image, "gif", new File( gifFileName ) );
    image.flush();

    return buf.toString();
  }
}