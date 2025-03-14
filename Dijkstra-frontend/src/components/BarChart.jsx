import React, { useEffect, useRef } from "react";
import * as d3 from "d3";

const BarChart = ({ data }) => {
    const svgRef = useRef();

    useEffect(() => {
        // Select the SVG element
        const svg = d3.select(svgRef.current);

        // Clear previous SVG content
        svg.selectAll("*").remove();

        // Define dimensions
        const width = 500;
        const height = 300;
        const margin = { top: 20, right: 20, bottom: 30, left: 40 };

        // Define scales
        const x = d3
            .scaleBand()
            .domain(data.map((d) => d.name))
            .range([margin.left, width - margin.right])
            .padding(0.1);

        const y = d3
            .scaleLinear()
            .domain([0, d3.max(data, (d) => d.value)])
            .nice()
            .range([height - margin.bottom, margin.top]);

        // Append axes
        svg
            .append("g")
            .attr("transform", `translate(0,${height - margin.bottom})`)
            .call(d3.axisBottom(x));

        svg
            .append("g")
            .attr("transform", `translate(${margin.left},0)`)
            .call(d3.axisLeft(y));

        // Append bars
        svg
            .selectAll(".bar")
            .data(data)
            .join("rect")
            .attr("class", "bar")
            .attr("x", (d) => x(d.name))
            .attr("y", (d) => y(d.value))
            .attr("width", x.bandwidth())
            .attr("height", (d) => y(0) - y(d.value))
            .attr("fill", "steelblue");
    }, [data]);

    return (
        <svg
            ref={svgRef}
            style={{
                width: 500,
                height: 300,
                border: "1px solid black",
            }}
        ></svg>
    );
};

export default BarChart;
