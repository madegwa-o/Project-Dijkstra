import * as d3 from 'd3';

const DUMMY_DATA = [
    {id: 'd1', value: '', region: 'rwanda'},
    {id: 'd2', value: '', region: 'massouri'},
    {id: 'd3', value: '', region: 'south africa'},
    {id: 'd4', value: '', region: 'Morrocco'},
];

d3.select('body').selectAll('body').data(DUMMY_DATA);