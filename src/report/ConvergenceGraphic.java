/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author bruno
 */
public class ConvergenceGraphic {
    
    public ConvergenceGraphic() {
    }
    
    public void generate(String name, int generation, double[][] dataSet) throws IOException{
        generateGraphcs(name, generation, dataSet);
    }
    
    private XYSeriesCollection createDataset(double[][] dataSet, int generation) {
        final XYSeries better = new XYSeries("Melhor");
        final XYSeries lesser = new XYSeries("Pior");
        final XYSeries mean = new XYSeries("Média");
        final XYSeries best = new XYSeries("Ótimo");
        for (int x = 0; x < generation; x++) {
            better.add(x, dataSet[x][0]);
            lesser.add(x, dataSet[x][1]);
            mean.add(x, dataSet[x][2]);
            best.add(x, 0);
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(best);
        dataset.addSeries(better);
        dataset.addSeries(mean);
        dataset.addSeries(lesser);

        return dataset;
        
        
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        for (int x = 0; x < generation; x++) {
//            dataset.addValue(dataSet[x][0], "Melhor", String.valueOf(x));
//            dataset.addValue(dataSet[x][1], "Pior", String.valueOf(x));
//            dataset.addValue(dataSet[x][2], "Média", String.valueOf(x));
//            dataset.addValue(0, "Ótimo", String.valueOf(x));
//        }
//        return dataset;
    }

    private void generateGraphcs(String name, int generation, double[][] dataSet) throws FileNotFoundException, IOException {
//        DefaultCategoryDataset ds = createDataset(dataSet, generation);
        XYDataset ds = createDataset(dataSet, generation);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico de Convergência do Algoritmo Genético", // chart title
                "Categorias", // x axis label
                "Fitness", // y axis label
                ds, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );
        
        
        
//        JFreeChart chart = ChartFactory.createLineChart(
//                "Gráfico de Convergência do Algoritmo Genético",
//                "Categorias",
//                "Fitness", ds,
//                PlotOrientation.VERTICAL, true, true, true);
//        CategoryItemRenderer renderer = chart.getCategoryPlot().getRenderer();
//        renderer.setSeriesPaint(0, Color.BLUE);
//        renderer.setSeriesPaint(1, Color.RED);
//        renderer.setSeriesPaint(2, Color.ORANGE);
//        renderer.setSeriesPaint(3, Color.GREEN);
        
        
        
        chart.setBackgroundPaint(Color.white);

        final XYPlot plot = chart.getXYPlot();
//        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        OutputStream arquivo = null;
        arquivo = new FileOutputStream(name + ".png");
        ChartUtilities.writeChartAsPNG(arquivo, chart, 550, 400);
    }
}
