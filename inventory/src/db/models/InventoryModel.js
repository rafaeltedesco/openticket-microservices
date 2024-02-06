/**
 * 
 * @param {import('sequelize').Sequelize} sequelize 
 * @param {import('sequelize').DataTypes} DataTypes 
 */
module.exports = (sequelize, DataTypes) => 
sequelize.define('Inventory', {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    name: DataTypes.STRING,
    eventDateTime: DataTypes.DATE,
    ticketsAvailable: DataTypes.INTEGER,
  }, {
    tableName: 'inventory',
    underscored: true,
    timestamps: false,
  });